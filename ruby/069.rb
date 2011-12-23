require 'utils'

MAX = 1_000_000

Integer.sieve(MAX)

$primes = Integer.primes

$max_quotient = -1
$max_n = 0

def search cur_num, start_index, cur_quotient
  #puts [cur_num, start_index, cur_quotient].inspect
  if start_index >= $primes.length or cur_num * $primes[start_index] > MAX
    if cur_quotient > $max_quotient    
      $max_quotient = cur_quotient
      $max_n = cur_num
    end
    return
  end
  (start_index...$primes.length).each do |i|
    if cur_num * $primes[i] > MAX
      break
    end
    search cur_num * $primes[i], i + 1, cur_quotient * $primes[i] * 1.0 / ($primes[i] - 1)
  end
end

search 1, 0, 1

puts $max_n

#puts (2..1_000_000).collect {|x| puts x; [x * 1.0 / x.phi, x]}.max[1]
