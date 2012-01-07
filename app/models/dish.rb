class Dish < ActiveRecord::Base
	validates_presence_of :name, :message => "must be completed"
	validates_uniqueness_of :name, :message => " - name already registered"
end
