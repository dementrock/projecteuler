fac = Hash.new { |f, n| f[n] = (n == 0 ? 1 : n * f[n - 1]) }
puts (10...1_000_000).select { |x| x == x.to_s.each_char.collect { |x| fac[x.to_i] }.inject(:+) }.inject(:+)
