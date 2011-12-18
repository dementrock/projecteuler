# Only possibilities: 9 = 4 + 1 + 4 = 2 + 3 + 4
require 'set'

satisfied = Set.new

# 4 + 1 + 4
(1...10).each do |x|
  (1000...10000).each do |y|
    z = x * y
    total = x.to_s + y.to_s + z.to_s
    if total.length == 9 and Set.new(total.each_char) == Set.new('1'..'9')
      satisfied.add z
    end
  end
end

# 2 + 3 + 4
(10...100).each do |x|
  (100...1000).each do |y|
    z = x * y
    total = x.to_s + y.to_s + z.to_s
    if total.length == 9 and Set.new(total.each_char) == Set.new('1'..'9')
      satisfied.add z
    end
  end
end

puts satisfied.inject(:+)
