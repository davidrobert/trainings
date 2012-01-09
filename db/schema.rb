# encoding: UTF-8
# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended to check this file into your version control system.

ActiveRecord::Schema.define(:version => 20120109214011) do

  create_table "clients", :force => true do |t|
    t.string   "name",       :limit => 80
    t.integer  "age"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "dishes", :force => true do |t|
    t.string   "name",       :limit => 80
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "dishes_restaurants", :id => false, :force => true do |t|
    t.integer "dishe_id"
    t.integer "restaurant_id"
  end

  create_table "qualifications", :force => true do |t|
    t.integer  "client_id"
    t.integer  "restaurant_id"
    t.float    "score"
    t.float    "amount_spent"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  add_index "qualifications", ["client_id"], :name => "index_qualifications_on_client_id"
  add_index "qualifications", ["restaurant_id"], :name => "index_qualifications_on_restaurant_id"

  create_table "recipes", :force => true do |t|
    t.integer  "dish_id"
    t.text     "content"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "restaurants", :force => true do |t|
    t.string   "name",       :limit => 80
    t.string   "address"
    t.datetime "created_at"
    t.datetime "updated_at"
    t.string   "specialty",  :limit => 40
  end

end
