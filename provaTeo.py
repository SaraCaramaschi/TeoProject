# Altri IMPORT
# import Dashboard_functions as f
import pandas as pd
import plotly.graph_objects as go
import collections
import dash
import dash_core_components as dcc
import dash_html_components as html
from dash.dependencies import Input, Output, State

# from dash_extensions import Download   DOWNLOAD PER UTENTE
# from dash_extensions.snippets import send_data_frame

################################## DATA PREPARATION


################################## DASHBOARD

# Initial dashboard settings
external_stylesheets = ['https://codepen.io/chriddyp/pen/bWLwgP.css']
app = dash.Dash(__name__, external_stylesheets=external_stylesheets)
background_color = '#b3cde0'

# LAYOUT GROUPING
app.layout = html.Div([
    dcc.Tabs(id='tabs-icij', value='tab-1', children=[
        dcc.Tab(label='Layout1: General overview', value='tab-1'),
        dcc.Tab(label='Layout2', value='tab-2'),
        dcc.Tab(label='Layout3', value='tab-3')
    ]),
    html.Div(id='tabs-example-content')
])


################################## FEATURE EXTRACTION
# countries_tot = list(devices.country.unique())
# categories = list(devices.classification.unique())
# risk = df[['description','country']]
# anni = f.find_year(events)

# Features related to different countries
# device_sum_country = devices['country'].value_counts()
# device_list_country = device_sum_country.tolist()
# device_index_country = device_sum_country.index.tolist()

# Features related to different events' type
# events_sum_type = events['type'].value_counts()
# events_list_type= events_sum_type.tolist()
# events_index_type = events_sum_type.index.tolist()

# Features related to different events' type and country
# event_sum_country = events['country'].value_counts()
# event_list_country = event_sum_country.tolist()
# event_index_country = event_sum_country.index.tolist()


################################## LAYOUT DEFINITION

# First tab layout definition

layout1 = html.Div([

    # TITOLO
    html.H1("Refrigerator action analysis over ...",
            style={'width': '55%', 'vertical-align': 'top', 'margin-left': '50px', 'marginBottom': 50,
                   'font-weight': 'bolder', 'margin-top': '70px'}),

    # SCELTE PARTICOLARI
    html.H2("Refrigerator selection : ",
            style={'width': '55%', 'vertical-align': 'top', 'margin-left': '50px', 'marginBottom': 50}),
    # commenti e lineeguida
    html.H2(
        "ciaociaociaociaooooooooooociaociaociaociaooooooooooociaociaociaociaooooooooooociaociaociaociaooooooooooo",
        style={'width': '55%', 'vertical-align': 'top', 'margin-left': '50px', 'marginBottom': 50,
               'font-size': '28px'}),

    # Menu a tendina
    html.Div([
        dcc.Dropdown(
            #  id="country",
            #  options=[{'label': country, 'value': country} for country in countries_tot]
        ),
    ], style={'width': '55%', 'vertical-align': 'top', 'margin-left': '50px', 'marginBottom': 50, "font-size": 12,
              'background-color': background_color}),

    # Sezione 2 grafici uno di fianco all'altro
    html.Div([
        html.Div([
            # html.H3('Distribution of devices per country ',style={'margin-left':'50px','marginBottom': 50}),
            dcc.Graph(id='devices_graph',
                      style={'width': '95%', 'vertical-align': 'top', 'margin-left': '50px', 'margin-top': '50px'})],
            className="six columns"),
        html.Div([
            # html.H3('Distribution of events per country',style={'margin-left':'50px','marginBottom': 50}),
            dcc.Graph(id='events_country',
                      style={'width': '95%', 'vertical-align': 'top', 'margin-left': '50px', 'margin-top': '50px'})],
            className="six columns"),
    ], className='row'),

    # Altro titolo (H1) e altro commento (H2)
    html.H1("Analysis over a selected period of time",
            style={'width': '55%', 'vertical-align': 'top', 'margin-left': '50px', 'margin-top': '70px',
                   'marginBottom': 50, 'font-weight': 'bolder'}),
    html.H2("Slide until the desired date",
            style={'width': '55%', 'vertical-align': 'top', 'margin-left': '50px', 'marginBottom': 50}),

    # Slider per selezionare arco di tempo
    html.Div([
        '''dcc.Slider(
            id="year", min=min(anni), max=max(anni), value=min(anni),
            marks={str(year): str(year) for year in anni}, step=1
        )'''
    ], style={'width': '60%', 'font-weight': 'bolder', 'margin-left': '560px'}),

    # Grafico
    html.Div([], id='years_events_country',
             style={'width': '70%', 'vertical-align': 'top', 'margin-left': '500px', 'margin-top': '50px'}),

    # Grafico
    html.Div([], id='risk',
             style={'width': '70%', 'vertical-align': 'top', 'margin-left': '500px', 'margin-top': '50px'}),

    '''
    html.H2(
        'We can state that the unique type of event often depends on the selected country. It is possible to verify that selecting the desired country and checking the correspondent pie graph',
        style={'width': '55%', 'vertical-align': 'top', 'margin-left': '50px', 'marginBottom': '50',
               'margin-top': '50px'}),
    html.H4('Field Safety Notice event type : {}'.format(dic[tipi[0]]),
            style={'width': '55%', 'vertical-align': 'top', 'margin-left': '50px', 'margin-top': '50px',
                   'marginBottom': 50}),
    html.H4('Safety Alert event type : {}'.format(dic[tipi[1]]),
            style={'width': '55%', 'vertical-align': 'top', 'margin-left': '50px', 'margin-top': '50px',
                   'marginBottom': 50}),
    html.H4('Recall event type : {}'.format(dic[tipi[2]]),
            style={'width': '55%', 'vertical-align': 'top', 'margin-left': '50px', 'margin-top': '50px',
                   'marginBottom': 50}),
    html.H4('Recall/Safety Alert event type : {}'.format(dic[tipi[3]]),
            style={'width': '55%', 'vertical-align': 'top', 'margin-left': '50px', 'margin-top': '50px',
                   'marginBottom': 50}),
    html.H4('Recall/Field Safety Notice event type : {}'.format(dic[tipi[4]]),
            style={'width': '55%', 'vertical-align': 'top', 'margin-left': '50px', 'margin-top': '50px',
                   'marginBottom': 50}),
    html.H4('Safety Alert/Field Safety Notice event type : {}'.format(dic[tipi[6]]),
            style={'width': '55%', 'vertical-align': 'top', 'margin-left': '50px', 'margin-top': '50px',
                   'marginBottom': 50}),'''
], style={'background-color': background_color})

# Second tab layout definition
layout2 = html.Div([
], style={'background-color': background_color})

# Third tab layout definition
layout3 = html.Div([

], style={'background-color': background_color})

'''
################################## MANAGING DAHSBOARD UPDATES

# Selection of the specific tab
@app.callback(
    Output('tabs-example-content', 'children'),
    [Input('tabs-icij', 'value')])
def render_content(tab):
    if tab == 'tab-1':
        return layout1
    elif tab == 'tab-2':
        return layout2
    elif tab == 'tab-3':
        return layout3


# Layout 1 updates


# Number of devices per country
@app.callback(
    Output('devices_graph', 'figure'),
    [Input('country', 'value')])
def update_graph_devicespercountry(country):

    return {}


# Type of events per country
@app.callback(
    Output('events_country', 'figure'),
    [Input('country', 'value')])
def update_graph_eventspercountry(country):

    return {}


# Amount of events per year in that country
@app.callback(
    Output('years_events_country', "children"),
    [Input("year", "value"),
     Input("country", "value")],
    [State('years_events_country', "children")])
def update_years_events_country(year, country, children):
    return {}

# Associated description for selected countries (ITA,FRA,TUR)
@app.callback(
    Output('risk', "children"),
    [Input("country", "value")],
    [State('risk', "children")])
def update_risk(country, children):
    return {}


# Layout 2

# Number of devices per single category
@app.callback(
    Output("n_dev_category", "children"),
    [Input("cat", "value")],
    [State("n_dev_category", "children")])

def update_n_dev_category(var, children):
    return {}


# Type of events of a single category
@app.callback(
    Output("events_setcat", "children"),
    [Input("cat", "value")],
    [State("events_setcat", "children")])

def update_graph_events_setcat(var, children):
    return {}

# Top 10 parent companies according to the number of associated events!

@app.callback(
    Output("manufacturers_category", "children"),
    [Input("cat", "value")],
    [State("manufacturers_category", "children")])
def update_graph_manufacturer_cat(cat, children):
    return {}

# Among the parent companies that have more associated events, highlight the manufacturers with highest num of events
@app.callback(
    Output("manufacturers_category_man", "children"),
    [Input("cat", "value")],
    [State("manufacturers_category_man", "children")])
def update_parent_events(cat, children):
    return {}

# Top 10 parent companies and the relative number of action summaries applied
@app.callback(
    Output("manuf_action", "children"),
    [Input("cat", "value")],
    [State("manuf_action", "children")])
def update_manuf_events(cat, children):
    return {}


# Layout 3

@app.callback(
    Output('container-button-basic', 'children'),
    [Input('show', 'n_clicks')],
    [State('input-on-submit', 'value')])

def update_output(n_clicks, value):
    return 'The input value was "{}" and the button has been clicked {} times'.format(
        value,
        n_clicks
    )


@app.callback(
    Output('result_pmid', 'children'),
    [Input('title', 'value')]
)
def update_pmid(title):
    print(title)
    if title:
        df = df_papers[df_papers['Title'] == title]
        pmid = df['Pmid'].tolist()[0]
        # to_print = "The pmid of the selected paper is {} The computed study type of the selectd paper is {} {}According to the ground truth is the selected paper relevant? {}".format(str(pmid),"\n",study_type,"\n",rel)
        return "The pmid of the selected paper is {}".format(pmid)

@app.callback(
    Output('result_studytype', 'children'),
    [Input('title', 'value')]
)
def update_studytype(title):
    if title:
        df = df_papers[df_papers['Title'] == title]
        study_type = df['Study Type'].tolist()[0]
        return "The computed study type of the selectd paper is {}".format(study_type)


@app.callback(
    Output('result_relevance', 'children'),
    [Input('title', 'value')]
)
def update_relevance(title):
    if title:
        df = df_papers[df_papers['Title'] == title]
        rel = df['Relevance GT'].tolist()[0]
        if rel == 0:
            out = 'Yes'
        else:
            out = 'No'

        return "According to performed analysis is the selected paper relevant? {}".format(out)

# grafico
@app.callback(
    Output("char", "children"),
    [Input('show', 'n_clicks')],
    [State("char", "children")])
def update_char(show, children):
    return {}

@app.callback(
    Output("char1", "children"),
    [Input('show', 'n_clicks')],
    [State("char1", "children")])
def update_char1(show, children):
    return {}


@app.callback(
    Output("rel", "children"),
    [Input('show', 'n_clicks')],
    [State("rel", "children")])

def update_rel(show, children):
    return {}


@app.callback(
    Output("years", "children"),
    [Input('show', 'n_clicks')],
    [State("years", "children")])
def update_years(show, children):
    return {}


# DOWNLOAD BUTTON
@app.callback(Output("download", "data"),
              [Input("btn", "n_clicks")])
def generate_csv(n_nlicks):
    return send_data_frame(df_papers.to_csv, filename="download_df1.csv")
'''

# end
if __name__ == '__main__':
    app.run_server()

