require 'utils'

MAX = 1_000_000

Integer.sieve(MAX)
primes = Integer.primes


max_len = Hash.new(0)

(0...(primes.length)).each do |i|
  sum = 0
  (i...(primes.length)).each do |j|
    sum += primes[j]
    if sum >= MAX
      break
    end
    if sum.prime?
      max_len[sum] = [max_len[sum], j - i + 1].max
    end
  end
end

puts max_len.to_a.collect { |x| x.reverse }.max[1]
