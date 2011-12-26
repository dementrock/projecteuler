require 'uri'
require 'net/http'

$card_dict = {
  'T' => 10,
  'J' => 11,
  'Q' => 12,
  'K' => 13,
  'A' => 14,
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
  values = get_values cards
  return [true, values.sort[-1], values.sort]
end

def one_pair? cards
  values = get_values cards
  values_frequency = get_frequency values
  return 
end

def first_win? line

end

cnt = 0

Net::HTTP.get(URI('http://projecteuler.net/project/poker.txt')).each_line do |x|
  if first_win? x.chomp.split
    cnt += 1
  end
end

puts cnt
