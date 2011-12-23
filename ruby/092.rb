def get_next x
  x.to_s.each_char.collect{ |x| x.to_i ** 2 }.inject(:+)
end

ends_with = Hash.new{|hash, key| hash[key] = (key == 1 or key == 89) ? key : hash[get_next key]}

cnt = 0

(1..1_000).each do |x|
  ends_with[x]
end

(1...10_000_000).each do |x|
  if ends_with[get_next x] == 89
    cnt += 1
  end
end

puts cnt
