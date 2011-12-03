puts Array(100..999).product(Array (100..999)).collect{|x| x[0]*x[1]}.select { |x| x.to_s == x.to_s.reverse }.max
