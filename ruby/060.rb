require 'utils'

MAX = 1_000_000

Integer.sieve(MAX)

$primes = []
$sprimes = []

(0..MAX).each do |x|
  if x.prime?
    $primes.push(x)
    $sprimes.push(x.to_s)
  end
end

def ok? lst # test if all combinations of the last prime with the previous one satisfy the condition
  p2 = $sprimes[lst[-1]]
  (0...lst.length - 1).each do |i|
    p1 = $sprimes[lst[i]]
    if not (p1+p2).to_i.prime? or not (p2+p1).to_i.prime?
      return false
    end
  end
  return true
end

def search_satisfied(now, rest, max)
  if rest == 0
    puts now.collect { |x| $primes[x] }.inject(:+)
    return true
  end
  if now.empty?
    start = 0
  else
    start = now[-1] + 1
  end
  (start...$primes.length).each do |i|
    if $primes[i] > max
      return false
    end
    if ok?(now + [i])
      if search_satisfied(now + [i], rest - 1, max)
        return true
      end
    end
  end
  return false
end
    
search_satisfied([], 5, 10000)
