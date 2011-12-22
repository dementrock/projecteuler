require 'utils'

is_twice_square = Hash.new(false)

MAX = 1_000_000

(1..10000).each do |x|
  is_twice_square[2*x*x] = true
end

Integer.sieve(MAX)

primes = Integer.primes

(9..MAX).step(2).each do |x|
  if not x.prime?
    satisfied = false
    primes.each do |y|
      if y >= x
        break
      end
      if is_twice_square[x-y]
        satisfied = true
        break
      end
    end
    if not satisfied
      puts x
      break
    end
  end
end
