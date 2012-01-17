require 'test_helper'

class QualificationsControllerTest < ActionController::TestCase
  setup do
    @qualification = qualifications(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:qualifications)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create qualification" do
    assert_difference('Qualification.count') do
      post :create, :qualification => @qualification.attributes
    end

    assert_redirected_to qualification_path(assigns(:qualification))
  end

  test "should show qualification" do
    get :show, :id => @qualification.to_param
    assert_response :success
  end

  test "should get edit" do
    get :edit, :id => @qualification.to_param
    assert_response :success
  end

  test "should update qualification" do
    put :update, :id => @qualification.to_param, :qualification => @qualification.attributes
    assert_redirected_to qualification_path(assigns(:qualification))
  end

  test "should destroy qualification" do
    assert_difference('Qualification.count', -1) do
      delete :destroy, :id => @qualification.to_param
    end

    assert_redirected_to qualifications_path
  end
end
