class Client < ActiveRecord::Base
	has_many :qualification

	validates_presence_of :name, :message => " - must be completed"
	validates_uniqueness_of :name, :message => " - name already registered"

	validates_numericality_of :age
	                          :greater_than => 0,
	                          :less_than => 100,
	                          :message => " - must be a number between 0 and 100"
end
