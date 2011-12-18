puts Array(1...100).product(Array(1...100)).collect {|x, y| (x ** y).to_s.each_char.collect{|x| x.to_i }.inject(:+) }.max
