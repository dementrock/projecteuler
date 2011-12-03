require 'prime'
sum_divisors = lambda {|x| x == 1 ? 1 : ((Prime.prime_division(x).collect{ |prime, exp| (prime ** (exp + 1) - 1) / (prime - 1)}.inject(:*)) - x)}
puts (1...10000).select{|x| x != sum_divisors.(x) and sum_divisors.(sum_divisors.(x)) == x}.inject(:+)
