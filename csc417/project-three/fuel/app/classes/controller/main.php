<!-- Marshall Bowers -->
<?php
    class Controller_Main extends Controller {
        public function action_index() {
            $view = ViewModel::forge('main/index');

            $sort = ['name', 'asc'];

            if (isset($_POST['sort'])) {
                $sort = $_POST['sort'];
            }

            $view->bind('sort', $sort);

            $view->items = DB::select()->from('item')->order_by($sort[0], $sort[1])->execute()->as_array();

            return Response::forge($view);
        }

        public function action_404() {
            return Response::forge(ViewModel::forge('main/404'));
        }

        public function action_401() {
            return Response::forge(ViewModel::forge('main/401'));
        }
    }
?>
