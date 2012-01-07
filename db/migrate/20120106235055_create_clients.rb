class CreateClients < ActiveRecord::Migration
  def self.up
    create_table :clients do |t|
			t.string :name, :limit => 80
			t.integer :age
      t.timestamps
    end
  end

  def self.down
    drop_table :clients
  end
end
