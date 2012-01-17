#encoding: utf-8
$: << File.expand_path(".")

require "report"

report1 = Report.instance
report2 = Report.instance

puts report1 == report2

report3 = Report2.instance
report4 = Report2.instance

puts report3 == report4
