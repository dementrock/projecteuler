class Integer

  def self.primes
    @@primes
  end

  def prime?
    now = self.to_i
    if @@sieved and now < @@sieve_max
      return @@isprime[now]
    end
    ulim = Math.sqrt(now).floor
    if @@sieved
      @@primes.each do |x|
        if x > ulim
          return true
        end
        if now % x == 0
          return false
        end
      end
      return true
    else
      (2..ulim).each do |x|
        if now % x == 0
            return false
        end
      end
      return true
    end
  end

  @@sieved = false

  def self.sieve(max)
    @@sieve_max = max
    @@sieved = true
    @@isprime = [false, false] + (2..max).to_a
    @@primes = []
    (2..Math.sqrt(max)).each do |x|
      if @@isprime[x]
        (2*x..max).step(x).each do |y|
          @@isprime[y] = false
        end
      end
    end
    (0..max).each do |x|
      if @@isprime[x]
        @@primes.push(x)
      end
    end
  end

  def factorial
    self.to_i > 0 ? (1..(self.to_i)).inject(:*) : 1
  end

  def palindrome?
    self.to_s.reverse.to_i == self.to_i
  end

  def factorize
    num = self.to_i
    lst = {}
    @@primes.each do |x|
      if num == 1
        break
      end
      if num % x == 0
        cnt = 0
        found = true
        while num % x == 0
          cnt += 1
          num = num / x
        end
        lst[x] = cnt
      end
    end
    lst
  end
end

class Comb
  def self.perm(lst)
    if lst.empty?
      []
    elsif lst.length == 1
      [lst]
    else
      res = []
      (0...lst.length).each do |x|
        #puts lst.inspect, (lst[0...x] + lst[x+1..-1]).inspect
        perm(lst[0...x] + lst[x+1..-1]).each do |y|
          res.push([lst[x]] + y)
        end
      end
      res
    end
  end
end
