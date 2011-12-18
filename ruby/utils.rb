class Integer

  def prime?
    if @@sieved and self.to_i < @@sieve_max
      return @@isprime[self.to_i]
    end
    (2..(Math.sqrt(self.to_i).floor)).each do |x|
        if self.to_i % x == 0
            return false
        end
    end
    return true
  end

  @@sieved = false

  def self.sieve(max)
    @@sieve_max = max
    @@sieved = true
    @@isprime = [false, false] + (2..max).to_a
    (2..Math.sqrt(max)).each do |x|
      if @@isprime[x]
        (2*x..max).step(x).each do |y|
          @@isprime[y] = false
        end
      end
    end
  end

  def factorial
    self.to_i > 0 ? (1..(self.to_i)).inject(:*) : 1
  end

  def palindrome?
    self.to_s.reverse.to_i == self.to_i
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
