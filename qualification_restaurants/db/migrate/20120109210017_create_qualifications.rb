class CreateQualifications < ActiveRecord::Migration
  def self.up
    create_table :qualifications do |t|
			t.integer :client_id
			t.integer :restaurant_id
			t.float :score
			t.float :amount_spent
      t.timestamps
    end

		add_index(:qualifications, :client_id)
		add_index(:qualifications, :restaurant_id)
  end

  def self.down
    drop_table :qualifications
  end
end
