class CreateDishes < ActiveRecord::Migration
  def self.up
    create_table :dishes do |t|
			t.string :name, :limit => 80
      t.timestamps
    end
  end

  def self.down
    drop_table :dishes
  end
end
