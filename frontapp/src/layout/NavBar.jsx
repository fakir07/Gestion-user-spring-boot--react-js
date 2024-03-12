import React from "react";
import { Link } from "react-router-dom";

const navbar = () => {
  return (
    <div>
      <nav className="navbar navbar-expand-lg bg-body-tertiary">
        <div className="container-fluid">
          <Link className="navbar-brand" to={"/"}>
            Gestion Users
          </Link>

          <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div className="navbar-nav">
              <Link
                className="nav-link active"
                aria-current="page"
                to={"/list"}
              >
                List User
              </Link>
              <Link className="nav-link" to={"/adduser"}>
                Add User
              </Link>
            </div>
          </div>
        </div>
      </nav>
    </div>
  );
};

export default navbar;
