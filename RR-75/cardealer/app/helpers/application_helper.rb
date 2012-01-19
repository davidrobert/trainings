module ApplicationHelper
	def hour_now
		uri = 'http://developer.yahooapis.com/TimeService/V1/getTime'
		response = Restfulie.at(uri).get(:appid => 'YahooDemo').resource
		yahoo_time = response['Result']['Timestamp'].to_i
		Time.at(yahoo_time).strftime("%d/%m/%Y %H:%M")
	end
end
