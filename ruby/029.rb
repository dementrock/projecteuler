puts Array(2..100).product(Array(2..100)).collect{|x, y| x**y}.uniq.length
