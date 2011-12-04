puts 1 + (2..501).collect{|i| 4*((2*i-1)**2) - 12*i + 12}.inject(:+)
