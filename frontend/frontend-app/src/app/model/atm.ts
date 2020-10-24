export interface Atm {
  id: string | null;
  distance: number;
  type: string;
  address: Address;
}

export interface Address {
  street: string;
  housenumber: string;
  postalcode: string;
  city: string;
  geoLocation: GeoLocation;
}

export interface GeoLocation {
  lat: string;
  lng: string;
}


export const atms: Atm[] = [{
  id: "5f942c8e857aba000130e0fc",
  distance: 0,
  type: "ING",
  address: {
    street: "Brugstraat",
    housenumber: "14",
    postalcode: "9711 HX",
    city: "Groningen",
    geoLocation: {"lat": "53.21644", "lng": "6.560568"}
  }
}, {
  id: "5f942c8e857aba000130e0f0",
  distance: 0,
  type: "ING",
  address: {
    street: "Gedempte Zuiderdiep",
    housenumber: "14",
    postalcode: "9711 HG",
    city: "Groningen",
    geoLocation: {"lat": "53.215365", "lng": "6.57033"}
  }
}, {
  id: "5f942c8f857aba000130e1ba",
  distance: 0,
  type: "ING",
  address: {
    street: "Gedempte Zuiderdiep",
    housenumber: "30",
    postalcode: "9711 HH",
    city: "Groningen",
    geoLocation: {"lat": "53.215054", "lng": "6.568989"}
  }
}, {
  id: "5f942c8f857aba000130e157",
  distance: 0,
  type: "ING",
  address: {
    street: "Hereplein",
    housenumber: "51",
    postalcode: "9711 GD",
    city: "Groningen",
    geoLocation: {"lat": "53.213807", "lng": "6.569764"}
  }
}, {
  id: "5f942c8e857aba000130dc91",
  distance: 0,
  type: "ING",
  address: {
    street: "Mira",
    housenumber: "25",
    postalcode: "5505 AR",
    city: "Veldhoven",
    geoLocation: {"lat": "51.413052", "lng": "5.397113"}
  }
}];
