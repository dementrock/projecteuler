require 'utils'

def comb(n, r)
  r > n ? 0 : (n.factorial / r.factorial / (n - r).factorial)
end

puts Array(1..100).product(Array(1..100)).select { |x, y| comb(x, y) > 1_000_000 }.count
