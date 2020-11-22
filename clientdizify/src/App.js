import React from "react";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import Album from "./Components/Album";
import Artiste from "./Components/Artiste";
import Playlist from "./Components/Playlist";
import Utilisateur from "./Components/Utilisateur";
import Titre from "./Components/Titre";

export default function App() {
  return (
    <Router>
      <div>
        <nav>
          <Link to="/">Home</Link>
          <Link to="/artistes">Artistes</Link>
          <Link to="/albums">Albums</Link>
          <Link to="/playlists">Playlists</Link>
          <Link to="/utilisateurs">Utilisateurs</Link>
          <Link to="/titres">Titres</Link>
        </nav>

        <Switch>
          <Route path="/artistes">
            <Artiste />
          </Route>
          <Route path="/albums">
            <Album />
          </Route>
          <Route path="/playlists">
            <Playlist />
          </Route>
          <Route path="/utilisateurs">
            <Utilisateur />
          </Route>
          <Route path="/titres">
            <Titre />
          </Route>
          <Route path="/">
            <Home />
          </Route>
        </Switch>
      </div>
    </Router>
  );
}

function Home() {
  return <h2>Home</h2>;
}
