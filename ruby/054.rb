require 'uri'
require 'net/http'
require 'set'

$card_dict = {
  'T' => 10,
  'J' => 11,
  'Q' => 12,
  'K' => 13,
  'A' => 14,
}

$evaluators = {
  1 => :high_card?,
  2 => :one_pair?,
  3 => :two_pairs?,
  4 => :three_of_a_kind?,
  5 => :straight?,
  6 => :flush?,
  7 => :full_house?,
  8 => :four_of_a_kind?,
  9 => :straight_flush?,
  10 => :royal_flush?,
}

def card_value x
  if ('2'..'9').include? x[0..0]
    x[0..0].to_i
  else
    $card_dict[x[0..0]]    
  end
end

def get_values cards
  cards.collect do |x| card_value x end
end

def get_frequency values
  freq = Hash.new(0)
  values.each do |x| freq[x] += 1 end
  freq
end

def high_card? cards
  return true
end

def win_values? val1, val2
  (0...val1.length).each do |i|
    if val1[i] < val2[i]
      return false
    elsif val1[i] > val2[i]
      return true
    end
  end
  return false
end

def get_highest card
  10.downto(1).each do |id|
    if method($evaluators[id]).call(card)
      return id
    end
  end
end

def sorted_by_freq cards
  values = get_values cards
  values_frequency = (get_frequency values).to_a
  values_frequency.sort! do |x, y|
    if x[1] > y[1] or (x[1] == y[1] and x[0] > y[0])
      -1
    else
      1
    end
  end
  return (values_frequency.collect{|x, y| x})
end

def win? card1, card2
  h1 = get_highest card1
  h2 = get_highest card2
  return ((h1 > h2) or ((h1 == h2) and (win_values? (sorted_by_freq card1), (sorted_by_freq card2))))
end

def one_pair? cards
  values = get_values cards
  values_frequency = get_frequency values
  values_frequency_2 = values_frequency.select {|key, value| value == 2}
  return values_frequency_2.length == 1
end

def two_pairs? cards
  values = get_values cards
  values_frequency = get_frequency values
  values_frequency_2 = values_frequency.select {|key, value| value == 2}
  return values_frequency_2.length == 2
end

def three_of_a_kind? cards
  values = get_values cards
  values_frequency = get_frequency values
  values_frequency_3 = values_frequency.select {|key, value| value == 3}
  return values_frequency_3.length == 1
end

def straight? cards
  values = (get_values(cards)).sort
  return values == (values[0]..values[-1]).to_a
end

def get_suits cards
  cards.collect{|x| x[1..1]}
end

def flush? cards
  suits = get_suits cards
  return (Set.new suits).to_a.length == 1
end

def full_house? cards
  values = get_values cards
  values_frequency = get_frequency values
  return ((values_frequency.values.include? 2) and (values_frequency.values.include? 3))
end

def four_of_a_kind? cards
  values = get_values cards
  values_frequency = get_frequency values
  return values_frequency.values.include?(4)
end

def straight_flush? cards
  return (flush? cards and straight? cards)
end

def royal_flush? cards
  values = get_values cards
  return (flush? cards and values.sort == [10, 11, 12, 13, 14])
end


def first_win? line
  return win? line[0..4], line[5..-1]
end

cnt = 0

Net::HTTP.get(URI('http://projecteuler.net/project/poker.txt')).each_line do |x|
  if first_win? x.chomp.split
    cnt += 1
  end
end

puts cnt
