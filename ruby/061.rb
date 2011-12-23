$start_with = Hash.new([])

generator = {
  3 => lambda { |n| n*(n+1)/2 },
  4 => lambda { |n| n*n },
  5 => lambda { |n| n*(3*n-1)/2 },
  6 => lambda { |n| n*(2*n-1) },
  7 => lambda { |n| n*(5*n-3)/2 },
  8 => lambda { |n| n*(3*n-2) },
}

def starts_with x
  x.to_s[0..1]
end

def ends_with x
  x.to_s[-2..-1]
end

def search num_lst, type_lst
  end_with = ends_with(num_lst[-1])
  complete = true
  (3..8).each do |num_type|
    if not type_lst.include? num_type
      complete = false
      $start_with[[num_type, end_with]].each do |next_num|
        if search num_lst + [next_num], type_lst + [num_type]
          return true
        end
      end
    end
  end
  if complete
    if ends_with(num_lst[-1]) == starts_with(num_lst[0])
      puts num_lst.inject(:+)
      return true
    end
  end
  return false
end

(3..8).each do |num_type|
  (1..1000).each do |i|
    num = generator[num_type].call(i)
    if num < 1000
      next
    elsif num >= 10000
      break
    end
    $start_with[[num_type, starts_with(num)]] += [num]
  end
end

(1..1000).each do |i|
  num = generator[3].call(i)
  if num < 1000
    next
  elsif num >= 10000
    break
  end
  if search [num], [3]
    break
  end
end
