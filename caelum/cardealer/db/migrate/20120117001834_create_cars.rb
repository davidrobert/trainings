class CreateCars < ActiveRecord::Migration
  def self.up
    create_table :cars do |t|
      t.string :name
      t.string :description
      t.float :value

      t.timestamps
    end
  end

  def self.down
    drop_table :cars
  end
end
