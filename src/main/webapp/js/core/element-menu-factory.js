require(["jquery", "context-menu", "map"], function($, contextMenu, layeredMap) {
	var factory = {
		factoryName: "element",
		getMenuItems: function(event, context) {
			/*
			 * 13th Exercise: Context aware items
			 * Modify the code of function to check if there is an element
			 * on those coordinates. In that case it should show only
			 * a "Remove Element" Action. Otherwise it will show 
			 * the "Add Element" Action.
			 */
			var list = [];
			var addItem = $("<li><div>Add Element</div></li>").attr({
                funcName: "add",
                params: JSON.stringify([ context.coordinate ])
            })
			list.push(addItem);
			return list;
		},
		add: function(coordinate) {
        	var requestJson = {
                    "ip": '126.124.12.12',
                    "lon": coordinate[0],
                    "lat": coordinate[1]
            }
            $.ajax({
                    method: "POST",
                    url: window.location.href + "rest/ne/create",
                    contentType: "application/json; charset=UTF-8",
                    data: JSON.stringify(requestJson),
                    headers: {
                        "Accept": "application/json",
                    }
            }).done(function(data) {
                    if(data.status == 0) {
                    	layeredMap.loadFeatures();
                    }
            }).fail(function(jqXHR, textStatus, errorThrown) {
                    if(jqXHR.status === 599) {
                        alert(jqXHR.responseText);
                    }
                    else {
                        alert(errorThrown);
                    }
            });
        }
	}
	/* 12th Exercise: Enable element specific actions
	 * Uncomment the following code line to enable more menu items.
	contextMenu.registerItemFactory(factory, 1);
	*/
});