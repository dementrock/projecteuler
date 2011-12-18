require 'rational'
require 'set'

def cancel(x, y)
  if x == y or x == y.to_s.reverse.to_i or x % 10 == 0 and y % 10 == 0
    return -1
  end
  #puts [x, y].inspect
  x, y = x.to_s, y.to_s
  duplicated = Set.new(x.each_char.to_a).intersection(Set.new(y.each_char.to_a))
  if duplicated.empty?
    return -1
  end
  duplicated.each do |char|
    while x.include?(char) and y.include?(char)
      x = x[0, x.index(char)].to_s + x[x.index(char)+1..-1]
      y = y[0, y.index(char)].to_s + y[y.index(char)+1..-1]
    end
  end
  if y.to_i == 0
    return -1
  end
  return Rational(x.to_i, y.to_i)
end

puts Array(10...100).product(Array(10...100)).select{ |x, y| x < y and Rational(x, y) == cancel(x, y)}.collect{ |x, y| Rational(x, y)}.inject(:*)
