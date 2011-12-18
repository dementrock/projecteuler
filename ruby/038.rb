require 'set'

class Integer
  def duplicated?
    x = self.to_s.each_char.to_a
    Set.new(x).to_a.sort != x.sort
  end
end

def check x
  if x.duplicated?
    return
  end
  str = x.to_s
  (2..9).each do |i|
    str += (x * i).to_s
    if str.to_i.duplicated? or str.length > 9
      return
    end
    if str.length == 9
      if str.each_char.to_a.sort == Array('1'..'9')
        puts str
      end
      return
    end
  end
end


  
check_set = [9] + (90..99).to_a + (900..999).to_a + (9000..9999).to_a

check_set.each do |x|
  check x
end
