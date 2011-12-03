puts 100.downto(1).inject(:*).to_s.split('').collect{|x| x.to_i}.inject(:+)
