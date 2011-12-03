require 'fileutils'
Dir.entries(Dir.pwd).each { |x|
  if x =~ /\d+\.rb$/ and x != x.rjust(6, '0')
    FileUtils.mv(x, x.rjust(6, '0'))
  end
}
