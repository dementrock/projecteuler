def satisfy? x
  (2..6).each do |i|
    if x.to_s.each_char.to_a.sort != (x * i).to_s.each_char.to_a.sort
      return false
    end
  end
  true
end

finish = false
(1..10).each do |x|
  (10**x..(10**(x+1))/6).each do |y|
    if satisfy? y
      puts y
      finish = true
      break
    end
  end
  if finish
    break
  end
end
