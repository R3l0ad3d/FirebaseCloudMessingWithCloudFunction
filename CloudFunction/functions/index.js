const functions = require('firebase-functions');

// // Create and Deploy Your First Cloud Functions
// // https://firebase.google.com/docs/functions/write-firebase-functions
//
// exports.helloWorld = functions.https.onRequest((request, response) => {
//  response.send("Hello from Firebase!");
// });
//import admin module
const admin = require('firebase-admin');
admin.initializeApp(functions.config().firebase);


// Listens for new messages added to messages/:pushId
exports.notifyForNewItem = functions.database.ref('/Root/Message/{ids}/{pushId}')
  .onCreate((snapshot, context) => {
  // Grab the current value of what was written to the Realtime Database
  const values = snapshot.val();
  const arr=Object.keys(values);
  const  key=arr[0];

  console.log(values);
  console.log(key);

  const payload = {
		notification: {
			"title": values.message,
			"body": values.time,
        
		},
	};
	return admin.messaging().sendToTopic("allUser", payload);
  
  // Create a notification
  
});