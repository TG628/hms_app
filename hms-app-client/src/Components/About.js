import React from 'react'
import NavBar from './NavBar'

export default function About() {
  return (
    <div>
      <NavBar />
      <div style={{ background: "linear-gradient(to left, yellow, skyblue,white)" }}>
        <a href="#myAnchor" className="go-top show"><i className="fa fa-angle-up"></i></a>
        <div className="wrapper" id="myAnchor">
          <div className="jquery-script-ads"></div>
        </div>

        <section className="about-page" >
          <div className="container">
            <div className="aboutrow12">

              <div className="row row2">
                <div className="col-md-12 col-sm-12 col-xs-12">
                  <div className="heading abt-head wow fadeInDown">
                    <h3 style={{ color: '#140E54' }}>Welcome to  Hospital Management System</h3>
                    <strong>What we are and our history</strong> </div>
                  <article className="wow fadeInDown" >
                    <p>HMS is a multi speciality hospital. We are dedicated to provide world className tertiary healthcare to people in India by fusing the benefits of modern technology with the clinical acumen of the leading specialists in their respective fields.
                      The technology advantage is complemented by the man power excellence providing sophisticated and specialised medical care at affordable cost.</p>
                    <p>We are a perfect blend of technological excellence, complete infrastructure,
                      competent care and heartfelt hospitality - this is how the people, whom we have been fortunate to serve, define the hospital.</p>
                    <strong>Mission</strong>
                    <p>The Mission of HMS is to provide a compassionate, accessible and affordable healthcare to the community to cultivate an environment of trust, equality and honesty.
                    </p>
                    <strong>Vision</strong>
                    <p>To create a benchmark in the field of healthcare and be a leading regional healthcare system that is dedicated in transforming the lives of people via excellent medical quality.
                    </p>
                    <strong>Values</strong>
                    <p><strong>Compassion:</strong> Providing patient- centered caring service to the members of the communities to enjoy a better, healthier life.</p>
                    <p><strong>Respect:</strong> Acting in the most economical and honest responsible ways, we will treat each individual with a caring consideration.</p>
                    <p><strong>Foresight:</strong> Setting ambitious goals, to move our community and healthcare system in a better and brighter future</p>
                  </article>
                </div>
              </div>
            </div>
          </div>
        </section>

        <section className="director_sec">
          <div className="container">
            <div className="row dir_inner">
              <h3 className="h3">Director’s Message</h3>

              <div className="row">
                <div className="col-md-3 col-sm-6 col-xs-12">
                  <article>
                    <img className="img-responsive" src="Tushar.jpg" alt="#" />
                    <div className="dir_txt">
                      <h4>Mr.Tushar Gaikwad</h4>
                      <p>It is of great pleasure for all the physicians, pathologists and all administrative staff at our multispecialty hospital to be one of the most reputed hospitals in the country. </p>

                      <div className="md-overlay"></div>
                    </div>
                  </article>
                </div>
                <div className="col-md-3 col-sm-6 col-xs-12">
                  <article>
                    <img className="img-responsive" src="Abhijit.jpg" alt="#" />
                    <div className="dir_txt">
                      <h4>Mr. Abhijit Chavan</h4>
                      <p>From the very beginning, we have been striving to provide the best to our patients in terms of
                        world-className medical facilities by utilizing our latest and innovative technologies and
                        techniques.</p>


                      <div className="md-overlay"></div>
                    </div>
                  </article>
                </div>
                <div className="col-md-3 col-sm-6 col-xs-12">
                  <article>
                    <img className="img-responsive" src="Akash.jpg" alt="#" />
                    <div className="dir_txt">
                      <h4>Mr. Akash Madke</h4>
                      <p>Since the establishment of the hospital, our team of doctors are providing substantial
                        treatments for all patients. We have laid a clear foundation for our mission and vision and are
                        constantly working towards it.</p>



                      <div className="md-overlay"></div>
                    </div>
                  </article>
                </div>
                <div className="col-md-3 col-sm-6 col-xs-12">
                  <article>
                    <img className="img-responsive img-center" src="Vinit.jpg" alt="#" />
                    <div className="dir_txt">
                      <h4>Mr. Vinit Gunjal</h4>
                      <p>Today, the world is becoming more and more competitive. Also, their health and the life
                        expectancy rate is dwindling. Hospitals are being opened frequently to give services to people
                        in the health care sector.</p>

                      <div className="md-overlay"></div>
                    </div>
                  </article>
                </div>
              </div>


            </div>
          </div>
        </section>



      </div>

    </div>
  )
}
