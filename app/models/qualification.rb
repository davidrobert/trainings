class Qualification < ActiveRecord::Base
	belongs_to :client
	belongs_to :restaurant

	validates_presence_of :client_id, :restaurant_id
	validates_associated :client, :restaurant

	validates_presence_of :score, :message => " - must be completed"	
	validates_presence_of :amount_spent, :message => " - must be completed"

	validates_numericality_of :score,
	                          :greater_than => 0,
	                          :less_than_or_equal_to => 10,
	                          :message => " - must be a number between 0 and 10"

	validates_numericality_of :amount_spent,
	                          :greater_than => 0,
	                          :message => " - must be a number greater than 0"
	                          
end
