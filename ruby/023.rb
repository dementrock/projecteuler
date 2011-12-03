require 'prime'
def satisfy? x
  $abundant_set.each { |i|
    if $abundant_has[x - i]
      return false
    end
  }
  return true
end
sum_divisors = lambda {|x| (Prime.prime_division(x).collect{ |prime, exp| (prime ** (exp + 1) - 1) / (prime - 1)}.inject(:*)) - x}
$abundant_set = (2..28123).select{|x| sum_divisors.(x) > x}
$abundant_has = Hash.new{|hash, key| hash[key] = $abundant_set.include? key}
puts (1..28123).select{|x| satisfy? x}.inject(:+)
