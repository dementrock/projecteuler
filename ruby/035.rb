require 'utils'

Integer.sieve(1_000_000)

class Integer
  def circprime?
    x, now, started = self.to_s, self.to_s, nil
    if x.to_i > 10 and x.match /[024568]/
      return nil
    end
    while now != x or not started
      started = 1
      if not now.to_i.prime?
        return nil
      end
      now = now[1..-1] + now[0..0]
    end
    return 1
  end
end

puts (1..1_000_000).select {|x| x.circprime?}.count
