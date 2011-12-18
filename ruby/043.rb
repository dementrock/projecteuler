$ans = []

$divisible = {
  4 => 2,
  5 => 3,
  6 => 5,
  7 => 7,
  8 => 11,
  9 => 13,
  10 => 17,
}

def search cur, lst
  if cur.length >= 4
    if (cur[-3..-1].to_i) % ($divisible[cur.length]) != 0
      return
    end
  end
  if lst.empty?
    $ans.push(cur.to_i)
    return
  end
  (0...lst.length).each do |i|
    search (cur+lst[i]), (lst[0...i] + lst[i+1..-1])
  end
end

search "", Array('0'..'9')

puts $ans.inject(:+)
