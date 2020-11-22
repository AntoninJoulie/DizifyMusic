import React from "react";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import Album from "./Components/Album";
import Artiste from "./Components/Artiste";

export default function App() {
  return (
    <Router>
      <div>
        <nav className="fill">
          <Link to="/">Home</Link>
          <Link to="/artistes">Artistes</Link>
          <Link to="/albums">Albums</Link>
        </nav>

        <Switch>
          <Route path="/artistes">
            <Artiste />
          </Route>
          <Route path="/albums">
            <Album />
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
  return (
    <div className="accueil">
      <h1>TP API REST - CAMBERT Killian & JOULIE Antonin</h1>
      <h3>Vous pouvez accéder aux différentes tables via la barre de navigation au dessus, vous êtes actuellement sur HOME</h3>
    </div>
  );
}
