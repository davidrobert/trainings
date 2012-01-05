class Report
	@@instance = Report.new

	def self.instance
		return @@instance
	end

	private_class_method :new
end

require 'singleton'

class Report2
	include Singleton
end

