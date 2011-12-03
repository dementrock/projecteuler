puts (2 ** 1000).to_s.split('').collect{|x| x.to_i}.inject(:+)
