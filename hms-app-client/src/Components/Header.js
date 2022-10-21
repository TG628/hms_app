function Header() {

    return (
        <div className="container-fluid position-sticky" style={{ backgroundColor: "#C6F0EE" }}>
            <div className="row justify-content-center" style={{ height: "12vh" }}>
                <div className="col-1 "><img src={process.env.PUBLIC_URL + '/hmslogo.png'} alt="logo" style={{ height: "65px" }}></img></div>
                <div className="col align-self-center" style={{ marginLeft: "6%", color: "#4D94C4" }}>
                    <h1 className="display-6"><strong>Hospital Management System</strong></h1>
                </div>
                <div className="col-3 "><img src={process.env.PUBLIC_URL + '/helpLine.png'} alt="helpLine" style={{ height: "75px" }} /></div>
            </div>
        </div>
    );
}

export default Header;