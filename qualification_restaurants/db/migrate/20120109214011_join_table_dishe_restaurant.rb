class JoinTableDisheRestaurant < ActiveRecord::Migration
  def self.up
		create_table :dishes_restaurants, {:id => false} do |t|
			t.integer :dish_id
			t.integer :restaurant_id
		end
  end

  def self.down
		drop_table :dishes_restaurants
  end
end
