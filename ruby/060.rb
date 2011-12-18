MAX = 1_000_000


$isprime = [nil, nil] + (2..MAX).to_a

def sieve()
  end 

sieve()

$primes = (2..MAX).select do |x| $isprime[x] end

def prime?(x)
  if x < MAX
    return $primes[x]
  end
  index = 0
  limit = Math.sqrt(x).floor
  while $primes[index] < limit
    if x % $primes[index] == 0
      return False
    end
    index += 1
  end
  return True
end

def search_satisfied(now, rest)
  if rest == 0
    puts now.inspect
    return True
  end
  start = now.empty? 0 : (now[-1] + 1)
  (start...$primes.length).each do |i|
    

end

search_satisfied([], 5)
  
