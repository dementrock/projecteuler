puts (10..1_000_000).select{|x| x == x.to_s.each_char.collect{|x| x.to_i ** 5}.inject(:+)}.inject(:+)
