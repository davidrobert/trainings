class AddColumnSpecialtyRestaurant < ActiveRecord::Migration
  def self.up
		add_column :restaurants, :specialty, :string, :limit => 40
  end

  def self.down
		remove_column :restaurants, :specialty
  end
end
