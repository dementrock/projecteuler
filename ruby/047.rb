require 'utils'

MAX = 10_000_000

Integer.sieve(MAX)

LEN = 4

class Integer
  def len_factorize
    num = self.to_i
    len = 0
    @@primes.each do |x|
      if x > num
        break
      end
      if num % x == 0
        while num % x == 0
          num = num / x
        end
        len += 1
        if num == 1
          break
        end
        if len > LEN
          return LEN + 1
        end
      end
    end
    return len
  end
end

cons = 0

(2..(1.0/0.0)).each do |x|
  if x.len_factorize == LEN
    cons += 1
    if cons == LEN
      puts x - LEN + 1
      break
    end
  else
    cons = 0
  end
end
