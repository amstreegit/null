import firebase from 'firebase';

const config = {
    apiKey: "AIzaSyASXv6tYvhpiSXIfXR5t3n0VP6gLTL8ZGk",
    authDomain: "amstree-905e6.firebaseapp.com",
    databaseURL: "https://amstree-905e6.firebaseio.com",
    projectId: "amstree-905e6",
    storageBucket: "amstree-905e6.appspot.com",
    messagingSenderId: "1044535017035"
};

firebase.initializeApp(config);

export const fb = firebase;
